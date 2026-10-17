
class Solution {
    public long[] solution(int[] arr, long l, long r) {
        long[] result = new long[2];
        long[] pos = new long[arr.length + 1];

        long index = 0, sum = 0, window = 0;
        long length = r - l + 1;

        // K, 첫 윈도우 합, 누적 위치 계산
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            long end = index + a;

            sum += a * Math.max(0L,
                Math.min(end, r) - Math.max(index, l - 1));
            window += a * Math.max(0L,
                Math.min(end, length) - index);

            pos[i + 1] = index = end;
        }

        result[0] = sum;
        if (window == sum) result[1]++;
        if (length == index) return result;

        // C 계산
        long left = 0, right = length;
        int i = 0, j = 0;

        while (pos[j + 1] <= right) j++;

        while (left < index - length) {
            long step = Math.min(index - length - left,
                Math.min(pos[i + 1] - left, pos[j + 1] - right));

            long delta = (long) arr[j] - arr[i];

            if (delta == 0) {
                if (window == sum) result[1] += step;
            } else {
                long diff = sum - window;
                if (diff % delta == 0 &&
                    diff / delta >= 1 && diff / delta <= step)
                    result[1]++;
            }

            window += delta * step;
            left += step;
            right += step;

            if (left == pos[i + 1]) i++;
            if (right == pos[j + 1]) j++;
        }

        return result;
    }
}
