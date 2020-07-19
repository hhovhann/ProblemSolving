package learning.hosttracker;

public interface Tracker {

    String allocate(String hostType);

    void deallocate(String hostName);
}
