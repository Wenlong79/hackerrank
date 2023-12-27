package com.wl.hakerrank;

import java.util.Arrays;

public class SecureServers {
    public static void main(String[] args) {
        int n = 4;
        int[] server = {2, 2, 3, 3};
        long k = 3;
        int result = findLargestMinVulnerability(server, k);
        System.out.println(result);
    }

    public static int findLargestMinVulnerability(int[] server, long k) {
        //Sort the array in non-decreasing order
        Arrays.sort(server);

        //Perform upgrades
        int n = server.length;
        int i = 0;
        while (k > 0 && i < n) {
            // Calculate the number of upgrades possible for the current server
            int upgrades = (int) Math.min(k, server[i] - 1);
            server[i] -= upgrades;
            i++;
            // Update remaining upgrades
            k -= upgrades;
        }

        //Return the smallest element in the modified array
        return Arrays.stream(server).min().orElse(-1);
    }
}


