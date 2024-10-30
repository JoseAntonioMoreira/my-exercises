public class Machine<T> {

    public T execute(MonoOperation<T> monoOperation, T n1){
        return monoOperation.execute(n1);
    }

    public T execute(BiOperation<T> biOperation, T n1, T n2){
        return biOperation.execute(n1,n2);
    }
}
