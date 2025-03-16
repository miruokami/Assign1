import java.util.*;

public class GenericsKb implements Comparable<GenericsKb>
{
    String term;
    String sentence;
    double confidenceScore;
    
    // Getter and setter methods for terms and sentences
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    // Getter and setter methods for confidenceScore
    public double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
    
    public GenericsKb(String line) {
            String[] parts = line.split("\t");
            term = parts[0]; // Assuming the term is the first part before tab

            if (parts.length > 1) {
                sentence = parts[1]; // The sentence part after the term
            } else {
                sentence = "";
            }

            if (parts.length > 2) {
                confidenceScore = Double.parseDouble(parts[2]); // Confidence score if present
            } else {
                confidenceScore = 0.0;
            }

        /** String[] parts = line.split("\t");
        term = parts[0];
    
        if (parts.length > 1) {
            sentence = parts[1];
        } else {
            sentence = ""; // or set it to null, depending on your preference
          }

        if (parts.length > 2) {
             confidenceScore = Double.parseDouble(parts[2]);
        } else {
            confidenceScore = 0;
         }*/
    }

    
    /** public int compareTo(GenericsKb gen)
    {	
        return (term+sentence).compareTo(gen.term+gen.sentence);
    }
    */
    
    public int compareTo(GenericsKb gen) {
        int termComparison = this.term.compareTo(gen.term);
    
        if (termComparison == 0) {
        // Terms are equal, compare sentences
            return this.sentence.compareTo(gen.sentence);
        } else {
            // Terms are different, return the comparison result
            return termComparison;
          }
    }
    
    public boolean contains(GenericsKb term) {
        // Check if the term or sentence contains the whole word or partial match
        return containsWord(term.getTerm()) || containsWord(term.getSentence());
    }

    private boolean containsWord(String text) {
        // Check if the text contains the whole word or partial match
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (word.equalsIgnoreCase(this.getTerm())) {
                return true;
            }
        }
        return false;
    }    
}