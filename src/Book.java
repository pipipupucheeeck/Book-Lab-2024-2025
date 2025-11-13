class Book
{
  public String pigLatin(String word)
  {
    String newWord = "";
    String vowels = "aeiouyAEIOUY";
    String digits = "0123456789";

    if (word.length() == 0)
    {
      return word + "yay";
    }
    else if (vowels.indexOf(word.substring(0, 1)) >= 0)
    {
      return word + "yay";
    }
    else if (digits.indexOf(word.substring(0, 1)) >= 0)
    {
      return word + "ay";
    }
    else if (word.length() == 1)
    {
      return word + "ay";
    }

    for (int i = 0; i < word.length(); i++)
    {
      if (vowels.indexOf(word.substring(i, i + 1)) >= 0)
      {
        String left = word.substring(0, i);
        String right = word.substring(i);

      
        boolean wasCapital = Character.isUpperCase(word.charAt(0));
        String result = right + left + "ay";
        if (wasCapital)
        {
          result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
        }
        return result;
      }
    }
    return newWord;
  }

  
  public int endPunctuation(String word)
  {
    int i = word.length() - 1;
    while (i >= 0 && !Character.isLetterOrDigit(word.charAt(i)))
    {
      i--;
    }
    if (i == -1)
      return 0; 
    if (i == word.length() - 1)
      return -1; 
    return i + 1;
  }

  
  public String translateWord(String word)
  {
    String convertedWord = "";
    int punctIndex = endPunctuation(word);

    if (punctIndex == 0)
    {
      convertedWord = word;
    }
    else if (punctIndex == -1)
    {
      convertedWord = pigLatin(word);
    }
    else
    {
      String core = word.substring(0, punctIndex);
      String punct = word.substring(punctIndex);
      convertedWord = pigLatin(core) + punct;
    }

    return convertedWord;
  }

  
  public String translateSentence(String sentence)
  {
    String retSentence = "";
    String[] words = sentence.split(" ");

    for (int i = 0; i < words.length; i++)
    {
      retSentence += translateWord(words[i]);
      if (i < words.length - 1)
        retSentence += " ";
    }

    return retSentence;
  }
}