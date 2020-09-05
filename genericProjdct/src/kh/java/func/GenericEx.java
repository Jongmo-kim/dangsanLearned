package kh.java.func;

public class GenericEx<T> {
	private T data;
	
	public GenericEx(T data) {
		super();
		this.data = data;
	}
	
	public GenericEx() {
		super();
		this.data = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
