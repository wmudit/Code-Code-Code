import java.util.*;

public class Flatten2DVector {

	private List<List<Integer>> vec2d;
	private int rowId;
	private int colId;
	private int numRows;

	public Flatten2DVector(List<List<Integer>> vec2d) {
		this.vec2d = vec2d;
		rowId = 0;
		colId = 0;
		numRows = vec2d.size();
	}

	public int next() {
		int ans = 0;

		if (colId < vec2d.get(rowId).size()) {
			ans = vec2d.get(rowId).get(colId);
		}

		colId++;

		if (colId == vec2d.get(rowId).size()) {
			colId = 0;
			rowId++;
		}

		return ans;
	}

	public boolean hasNext() {
		while (rowId < numRows && (vec2d.get(rowId) == null || vec2d.get(rowId).isEmpty())) {
			rowId++;
		}

		return vec2d != null && !vec2d.isEmpty() && rowId < numRows;
	}
	
}