import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;

public class TextAnalyzerGUI {
    private JFrame frame;
    private JTextField textField;
    private JTextArea textArea;
    private JList<String> wordList;
    private Map<String, WordStats> wordStatsMap;

    public TextAnalyzerGUI(Map<String, WordStats> wordStatsMap) {
        this.wordStatsMap = wordStatsMap;
        frame = new JFrame("Text Analyzer");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder("Enter a word:"));

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        wordList = new JList<>(wordStatsMap.keySet().toArray(new String[0]));
        wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        wordList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedWord = wordList.getSelectedValue();
                textField.setText(selectedWord);
                textField.postActionEvent();
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = textField.getText();
                WordStats wordStats = wordStatsMap.get(word);
                if (wordStats != null) {
                    textArea.setText("Total count: " + wordStats.totalCount + "\n" +
                            "Sentence count: " + wordStats.sentenceCount + "\n" +
                            "First sentence: " + wordStats.firstSentence + "\n" +
                            "Most occurrences sentence: " + wordStats.mostOccurrencesSentence);
                } else {
                    textArea.setText("Word not found");
                }
            }
        });

        frame.add(textField, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(new JScrollPane(wordList), BorderLayout.EAST);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Map<String, WordStats> wordStatsMap = TextAnalyzerApp.analyzeText(selectedFile.getPath());
            new TextAnalyzerGUI(wordStatsMap);
        }
    }
}