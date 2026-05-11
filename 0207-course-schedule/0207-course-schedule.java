class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] completed = new boolean[numCourses];
        int finished = 0;

        while (finished < numCourses) {

            boolean progress = false;

            for (int course = 0; course < numCourses; course++) {

                // already completed
                if (completed[course]) {
                    continue;
                }

                boolean canTake = true;

                // check all prerequisites
                for (int[] pre : prerequisites) {

                    int curr = pre[0];
                    int req = pre[1];

                    if (curr == course && !completed[req]) {
                        canTake = false;
                        break;
                    }
                }

                // take course
                if (canTake) {
                    completed[course] = true;
                    finished++;
                    progress = true;
                }
            }

            // no course could be completed
            if (!progress) {
                return false;
            }
        }

        return true;
    }
}