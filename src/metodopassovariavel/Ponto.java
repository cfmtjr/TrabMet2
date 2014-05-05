package metodopassovariavel;

public class Ponto<T> {
    
    private T t;
    private T w;
    private T h;
    
    public Ponto(T t, T w, T h) {
        this.t = t;
        this.w = w;
        this.h = h;
    }

    public T getH() {
        return h;
    }

    public void setH(T h) {
        this.h = h;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public T getW() {
        return w;
    }

    public void setW(T w) {
        this.w = w;
    }

}
