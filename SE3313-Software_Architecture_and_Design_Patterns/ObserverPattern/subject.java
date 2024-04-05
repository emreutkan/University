public interface subject {
    void registerSubscriber(observer o);
    void removeSubscriber(observer o);
    void notifySubscriber();
}
