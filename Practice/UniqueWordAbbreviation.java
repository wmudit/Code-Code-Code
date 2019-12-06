import java.util.*;

public class UniqueWordAbbreviation {

	private Set<String> uniqueDict;
	private Map<String, String> abbrDict;

	public UniqueWordAbbreviation(String[] dictionary) {
		uniqueDict = new HashSet<>();
		abbrDict = new HashMap<>();

		for (String word : dictionary) {
			if (!uniqueDict.contains(word)) {
				String abbr = getAbbr(word);
				if (!abbrDict.containsKey(abbr)) {
					abbrDict.put(abbr, word);
				} else {
					abbrDict.put(abbr, "");
				}

				uniqueDict.add(word);
			}
		}
	}

	public boolean isUnique(String word) {
		if (word == null || word.length() == 0) {
			return true;
		}

		String abbr = getAbbr(word);
		if (!abbrDict.containsKey(abbr) || abbrDict.get(abbr).equals(word)) {
			return true;
		} else {
			return false;
		}
	}

	private String getAbbr(String word) {
		if (word == null || word.length() < 3) {
			return word;
		}

		StringBuffer sb = new StringBuffer();
		sb.append(word.charAt(0));
		sb.append(word.length() - 2);
		sb.append(word.charAt(word.length() - 1));

		return sb.toString();

	}

}
