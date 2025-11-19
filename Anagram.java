/** Functions for checking if a given string is an anagram. */
public class Anagram 
{
	public static void main(String args[]) 
	{
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) 
		{
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  


	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) 
	{
		str1= preProcess(str1);
		str2= preProcess(str2);
		int n1=  str1.length();
		int n2=  str2.length();
		boolean b;
		
		if (n1 != n2)
         return false;

		char[] arr2 = new char[n2];
        for (int i = 0; i < n2; i++) 
		{
        arr2[i] = str2.charAt(i);
		}

		for (int i = 0; i < n1; i++) 
		{
        char c = str1.charAt(i);
        b = false;

		for (int j = 0; j < arr2.length; j++) 
		{
            if (arr2[j] == c) 
			{
                arr2[j] = '#'; 
                b = true;
                break;       
			}
		}
		if (b==false)
		 return false;
		}
		
		return true;
	}

	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) 
	{
	String result = "";

    for (int i = 0; i < str.length(); i++) 
	{
        char c = str.charAt(i);

        if (Character.isLetter(c)) 
         result = result + Character.toLowerCase(c);    
    }
    return result;
}
	
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) 
	{
		String result = "";

    // Convertir str en tableau modifiable
    char[] arr = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
        arr[i] = str.charAt(i);
    }

    // Construire l'anagramme en choisissant des index aléatoires
    for (int k = 0; k < arr.length; k++) 
	{

        // Chercher un index non utilisé
        int index = (int)(Math.random() * arr.length);

        // Tant que le caractère est déjà utilisé → tirer un autre index
        while (arr[index] == '#') {
            index = (int)(Math.random() * arr.length);
        }

        // Ajouter ce caractère au résultat
        result = result + arr[index];

        // Marquer ce caractère comme utilisé
        arr[index] = '#';
    }

    return result;
}
		
}