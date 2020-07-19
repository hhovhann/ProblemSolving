package learning.hosttracker;

import java.util.*;
/***
 *     Host Tracker:
 *
 *     Server names consist of an alphabetic host type (e.g. "apibox") concatenated,
 *     with the server number, with server numbers allocated sequentially (so, "apibox:1", "apibox:2", etc. are valid host names).
 *     Write a name tracking class with two operations, "allocate(hostType)" and "deallocate(hostName)".
 *     The former should reserve and return the next available hostname,
 *     while the latter should release that hostname back into the pool.
 */
public class HostTracker implements Tracker {
    private final static String DELIMITER = ":";
    private static Map<String, List<Integer>> hostNamesPool;

    protected HostTracker() {
        hostNamesPool = new HashMap<>();
    }

    @Override
    public String allocate(String hostType) {
        List<Integer> allocatedServerNumbers = new ArrayList<>();
        if (hostNamesPool.containsKey(hostType)) {
            allocatedServerNumbers = hostNamesPool.get(hostType);
            int nextServerNumber = getNextServerNumber(allocatedServerNumbers);
            allocatedServerNumbers.add(nextServerNumber);
            hostNamesPool.put(hostType, allocatedServerNumbers);
            return generateServerHostname(hostType, nextServerNumber);
        } else {
            int nextServerNumber = getNextServerNumber(allocatedServerNumbers);
            allocatedServerNumbers.add(nextServerNumber);
            hostNamesPool.put(hostType, allocatedServerNumbers);
            return generateServerHostname(hostType, nextServerNumber);
        }
    }

    @Override
    public void deallocate(String hostName) {
        String[] hostNameArr = hostName.split(DELIMITER);
        String hostType = hostNameArr[0];
        int serverNumber = Integer.parseInt(hostNameArr[1]);
        if (hostNamesPool.containsKey(hostType)) {
            hostNamesPool.get(hostType).removeIf(integer -> integer == serverNumber);
        } else {
            System.out.println("There is no any allocated servers with hostname: " + hostName);
        }
    }

    private String generateServerHostname(String hostType, int serverNumber) {
        return String.join(DELIMITER, hostType, String.valueOf(serverNumber));
    }

    private int getNextServerNumber(List<Integer> currentNumbers) {
        int nextServerNumber = 1;
        if (currentNumbers.isEmpty()) return nextServerNumber;
        nextServerNumber = Collections.max(currentNumbers);
        for (int i = 1; i < nextServerNumber; i++) {
            boolean containsValue = currentNumbers.contains(i);
            if (!containsValue) {
                return i;
            }
        }
        return nextServerNumber + 1;
    }
}
