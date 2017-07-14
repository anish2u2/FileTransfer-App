package org.factory.design.contracts;

public interface Factory {

	public void initFactory(Context appContext);

	public void destroyContext();

	public interface Creator<T> {
		public T createObject();
	}

}
