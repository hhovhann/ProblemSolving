package learning.hosttracker;

public class Solution {
    /*
    Host Tracker: Server names consist of an alphabetic host type (e.g. "apibox") concatenated,
    with the server number, with server numbers allocated sequentially (so, "apibox:1", "apibox:2", etc. are valid hostnames).
    Write a name tracking class with two operations, "allocate(hostType)" and "deallocate(hostName)".
    The former should reserve and return the next available hostname,
    while the latter should release that hostname back into the pool.

    For example:
    tracker = new Tracker();

    tracker.allocate("apibox");
    >> "apibox:1"

    tracker.allocate("apibox");
    >> "apibox:2"

    tracker.deallocate("apibox:1");
    tracker.allocate("apibox");
    >> "apibox:1"

    tracker.allocate("apibox");
    >> "apibox:3"

    tracker.deallocate("apibox:2");
    tracker.allocate("apibox");
    >> "apibox:2"

    tracker.allocate("sitebox");
    >> "sitebox:1"

    * */
    public static void main(String[] args) {
        var tracker = new HostTracker();
        String result1 = tracker.allocate("apibox");  //Step 1: tracker.allocate("apibox");    >> "apibox:1"
        String result2 = tracker.allocate("apibox");  //Step 2: tracker.allocate("apibox");    >> "apibox:2"
        tracker.deallocate("apibox:1");              //Step 3: tracker.deallocate("apibox:1");
        String result3 = tracker.allocate("apibox");  //Step 4: tracker.allocate("apibox");    >> "apibox:1"
        String result4 = tracker.allocate("apibox");  //Step 5: tracker.allocate("apibox");    >> "apibox:3"
        tracker.deallocate("apibox:2");              //Step 6: tracker.deallocate("apibox:2");
        String result5 = tracker.allocate("apibox");  //Step 7: tracker.allocate("apibox");    >> "apibox:2"
        String result6 = tracker.allocate("sitebox"); //Step 8: tracker.allocate("sitebox");   >> "sitebox:1"
    }
}
