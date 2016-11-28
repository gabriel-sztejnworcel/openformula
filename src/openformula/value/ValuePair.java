
package openformula.value;

public class ValuePair
{
	private Value first;
	private Value second;
	
	public ValuePair(Value first, Value second)
	{
		this.first = first;
		this.second = second;
	}

	public Value getFirst()
	{
		return first;
	}

	public Value getSecond()
	{
		return second;
	}
}
