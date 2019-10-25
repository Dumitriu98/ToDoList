package ro.gr8.jsp.data.repository;

public class Proxy {
    private String delegate = new String();

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return delegate.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public String toString() {
        return "Delegate says: " + delegate.toString();
    }

    public int length(){
        return delegate.length() + 15;
    }
}
