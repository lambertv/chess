public class Move {
    public int start_x;
    public int start_y;
    public int end_x;
    public int end_y;
    public int capture_x;
    public int capture_y;

    public Move(int start_x, int start_y, int end_x, int end_y) {
        this.start_x = start_x;
        this.start_y = start_y;
        this.end_x = end_x;
        this.end_y = end_y;
        this.capture_x = end_x;
        this.capture_y = end_y;
    }

    public String toString() {
        return ("(" + start_x + ", " + start_y + ") to (" + end_x + ", " + end_y + ")");
    }
}
