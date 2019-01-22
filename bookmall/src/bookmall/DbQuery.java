package bookmall;

public interface DbQuery<T> {

	public boolean insert(T vo);
	public boolean update(T vo);
	public T select(T vo);
	public boolean delete(T no);
	
	
}
