package DS1115;
public class  MyString 
{
	int code = 31;
	String value;
	int hash = 0;

	public MyString(String _str, int _code)
	{
		this.value = _str;
		this.code = _code;
	}

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}

	public String getString()
	{
		return value;
	}
	public int getCode()
	{
		return code;
	}

	public void setcode(int mycode)
	{
		code = mycode;
	}
	public String toString()
	{
		return value;
	}
        
	public boolean equals(Object o) {
		try {
			MyString mst = (MyString)o;
			return this.value.equals(mst.value);
		} catch (Exception ex) {
			return false;
		}
	}
        


	public int hashCode() {
		int h = hash;
		int offset =0;
		if (h == 0) {
			int off = offset;
			char val[] = value.toCharArray();
			int len = value.length();

			for (int i = 0; i < len; i++) {
				h = code*h + val[off++];
			}
			//h = h % 127;
			hash = h;
		}
		//return value.hashCode();
		return h;
	}
}
