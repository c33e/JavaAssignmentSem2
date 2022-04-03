
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Class
//To find maximum occurrences
public class fileProcessor{
	
	File file1 = new File("sunflowers.txt");
	File file2 = new File("wildflowers.txt");
	public static String[] stopwords = {".", ",", "?", "!", "a", "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", "course", "currently", "definitely", "described", "despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", "just", "keep", "keeps", "kept", "know", "knows", "known", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides", "que", "quite", "qv", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", "ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "They", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "value", "various", "very", "via", "viz", "vs", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "zero"};
	ArrayList<String> fileArray1 = new ArrayList<String>();
	ArrayList<String> fileArray2 = new ArrayList<String>();
	Scanner myScanner, myScanner2;
    String word;
	Integer count;
	//private String Role;
	
	public void openFile() {
	 
		try
		{
		    myScanner = new Scanner(file1);
		    myScanner2 = new Scanner(file2);
		    
		    while (myScanner.hasNextLine())
		    {
		        fileArray1.add(myScanner.next());
		        
		    }
	           
			while (myScanner2.hasNextLine())
			{
			     fileArray2.add(myScanner2.next());
			}
		   
		}
		catch(FileNotFoundException e)
		{
			System.out.println("An error has occured: " + e.getMessage());
		}
		
	}
	
	public void cleanFile() 
	{
	     //remove stop words here from the temp list
        for (int i = 0; i < fileArray1.size(); i++) 
        {
            // get the item as string
            for (int j = 0; j < stopwords.length; j++) {
                if (stopwords[j].contains(fileArray1.get(i))) {
                    fileArray1.remove(i);
                }
            }
        }
        
	     //remove stop words here from the temp list
        for (int i = 0; i < fileArray2.size(); i++) 
        {
            // get the item as string
            for (int j = 0; j < stopwords.length; j++) {
                if (stopwords[j].contains(fileArray2.get(i))) {
                    fileArray2.remove(i);
                }
            }
        }
	}
	
	public void readFile(Map<String, Integer> words, String word) 
	{
		
		while(myScanner.hasNextLine())
		{
			String contains = myScanner.next();
			Integer count = words.get(contains);
			if (word.equals(contains)) {
				System.out.println("Word is in the file");
			}
			
		   fileArray1.add(myScanner.next());
	       
           if (count != null) {
               count++;
           }
           else
               // default if word appears just one time
               count = 1;
           words.put(word, count);
		}
		myScanner.close();
	}
	
	public void Compare() 
	{
		
		ArrayList<String> fileArray1Copy = new ArrayList<String>(fileArray1);
		fileArray1Copy.retainAll(fileArray2);
		
        Set<String> set = new LinkedHashSet<>();
        
        // Add the elements to set
        set.addAll(fileArray1Copy);
  
        // Clear the list
        fileArray1Copy.clear();
  
        // add the elements of set
        // with no duplicates to the list
        fileArray1Copy.addAll(set);
        System.out.println("Common elements: " + fileArray1Copy);
	}
	
	public void top10() 
	{
        List<String> combinedList = Stream.of(fileArray1, fileArray2)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        //System.out.println(combinedList);
		Map<String, Long> map = combinedList.stream()
		        .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

		List<Map.Entry<String, Long>> result = map.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		        .limit(10)
		        .collect(Collectors.toList());
		System.out.println(result);
	}

}
