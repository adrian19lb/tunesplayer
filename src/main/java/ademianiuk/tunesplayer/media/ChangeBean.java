package ademianiuk.tunesplayer.media;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChangeBean<T> {

    private PropertyChangeSupport support;
    
    private T changedValue;

    private final String propertyName;

    public ChangeBean(String propertyName) {
        this.propertyName = propertyName;
        this.support = new PropertyChangeSupport(this);
    }

    public void add(PropertyChangeListener listener) {
       this.support.addPropertyChangeListener(listener);
    }

    public void remove(PropertyChangeListener listener) {
       this.support.removePropertyChangeListener(listener);
    }

    public T getValue() {
       return this.changedValue;
    }

    public void set(T value) {
        this.support.firePropertyChange(propertyName, changedValue, value); 
        this.changedValue = value;
    }

};
