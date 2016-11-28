
package openformula.spreadsheet;

import java.text.ParseException;
import java.util.GregorianCalendar;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import openformula.spreadsheet.Cell.CellValueType;
import openformula.util.Convert;
import openformula.util.Unzipper;
import openformula.util.XmlUtil;

public class SpreadsheetLoader
{
	private static final String CONTENT_FILE_NAME = "content.xml";
	private static final String NS_OFFICE = "urn:oasis:names:tc:opendocument:xmlns:office:1.0";
	private static final String NS_TABLE = "urn:oasis:names:tc:opendocument:xmlns:table:1.0";

	public Spreadsheet loadOds(String path) throws Exception
	{
		Spreadsheet spreadsheet = new Spreadsheet();
		Document contentDoc = loadContentDoc(path);
		loadSheets(spreadsheet, contentDoc);
		return spreadsheet;
	}

	private Document loadContentDoc(String path) throws Exception
	{
		Unzipper unzipper = new Unzipper(path);
		byte[] buf = unzipper.extractToBuf(CONTENT_FILE_NAME);
		Document doc = XmlUtil.getDocFromBuffer(buf);
		return doc;
	}

	private void loadSheets(Spreadsheet spreadsheet, Document contentDoc)
	{
		NodeList tableElements = contentDoc.getElementsByTagNameNS(NS_TABLE, "table");
		
		for (int i = 0; i < tableElements.getLength(); ++i)
		{
			Element tableElement = (Element) tableElements.item(i);
			String sheetName = tableElement.getAttributeNS(NS_TABLE, "name");
			Sheet sheet = spreadsheet.addSheet(sheetName);
			loadCellsFromSheet(sheet, tableElement);
		}
	}
	
	private void loadCellsFromSheet(Sheet sheet, Element tableElement)
	{
		NodeList rowElements = tableElement.getElementsByTagNameNS(NS_TABLE, "table-row");
		int rowNum = 0;
		
		for (int i = 0; i < rowElements.getLength(); ++i)
		{
			Element rowElement = (Element) rowElements.item(i);
			int repeatRows = 1;
			String repeatStr = rowElement.getAttributeNS(NS_TABLE, "number-rows-repeated");
			
			if (!repeatStr.isEmpty())
			{
				repeatRows = Integer.parseInt(repeatStr);
			}
			
			loadCellsFromRow(sheet, rowElement, rowNum, repeatRows);
			rowNum += repeatRows;
		}
	}
	
	private void loadCellsFromRow(Sheet sheet, Element rowElement, int rowNum, int repeatRows)
	{
		NodeList cellElements = rowElement.getElementsByTagNameNS(NS_TABLE, "table-cell");
		int colNum = 0;
		
		for (int i = 0; i < cellElements.getLength(); ++i)
		{
			Element cellElement = (Element) cellElements.item(i);
			int repeatCols = 1;
			
			String repeatStr = cellElement.getAttributeNS(NS_TABLE, "number-columns-repeated");
			
			if (!repeatStr.isEmpty())
			{
				repeatCols = Integer.parseInt(repeatStr);
			}

			CellValueType cellValueType = getCellValueType(cellElement);
			
			if (cellValueType != CellValueType.EMPTY)
			{
				for (int j = 0; j < repeatRows; ++j)
				{
					for (int k = 0; k < repeatCols; ++k)
					{
						String cellPosition = getCellPos(rowNum + j, colNum + k);
						setCell(sheet, cellPosition, cellValueType, cellElement);
					}
				}
			}
			
			colNum += repeatCols;
		}
	}

	private void setCell(Sheet sheet, String cellPosition, CellValueType cellValueType, Element cellElement)
	{
		String formula = cellElement.getAttributeNS(NS_TABLE, "formula");
		
		if (!formula.isEmpty())
		{
			sheet.setFormulaCell(cellPosition, formula, cellValueType);
		}
		else
		{
			String strValue = null;
			
			switch (cellValueType)
			{
			case NUMBER:
				strValue = cellElement.getAttributeNS(NS_OFFICE, "value");
				Double numberValue = Double.parseDouble(strValue);
				sheet.setConstCell(cellPosition, numberValue);
				break;
				
			case STRING:
				strValue = cellElement.getAttributeNS(NS_OFFICE, "string-value");
				sheet.setConstCell(cellPosition, strValue);
				break;
				
			case DATE:
				strValue = cellElement.getAttributeNS(NS_OFFICE, "date-value");
				GregorianCalendar dateValue = null;
				
				try
				{
					dateValue = Convert.stringToDate(strValue, "yyyy-MM-dd");
				}
				catch (ParseException e)
				{

				}
				
				sheet.setConstCell(cellPosition, dateValue);
				break;
				
			case BOOLEAN:
				strValue = cellElement.getAttributeNS(NS_OFFICE, "boolean-value");
				Boolean booleanValue = strValue.equals("true");
				sheet.setConstCell(cellPosition, booleanValue);
				break;
				
			default:
				throw new UnsupportedOperationException();
			}
		}
	}

	private CellValueType getCellValueType(Element cellElement)
	{
		CellValueType cellValueType = CellValueType.EMPTY;
		String valueTypeAttr = cellElement.getAttributeNS(NS_OFFICE, "value-type");
		
		if (valueTypeAttr.equals("float"))
		{
			cellValueType = CellValueType.NUMBER;
		}
		else if (valueTypeAttr.equals("string"))
		{
			cellValueType = CellValueType.STRING;
		}
		else if (valueTypeAttr.equals("boolean"))
		{
			cellValueType = CellValueType.BOOLEAN;
		}
		else if (valueTypeAttr.equals("date"))
		{
			cellValueType = CellValueType.DATE;
		}
		
		return cellValueType;
	}

	private String getCellPos(int rowNum, int colNum)
	{
		return convertColNumToPosStr(colNum) + Integer.toString(rowNum + 1);
	}
	
	private String convertColNumToPosStr(int colNum)
	{
		String colPosStr = "";
		
		if (colNum < 26)
		{
			colPosStr = Character.toString((char)('A' + colNum));
		}
		else
		{
			colPosStr = convertColNumToPosStr(colNum / 26 - 1) + convertColNumToPosStr(colNum % 26);
		}
		
		return colPosStr;
	}
}
