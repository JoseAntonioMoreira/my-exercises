package io.codeforall.bootcamp.GameObjects;

public interface Destroyable {
    
    public abstract void hit(int damage);
    public abstract boolean isDestroyed();
}
