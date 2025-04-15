package conjuncaodisjuncao;
import javax.swing.JOptionPane;

public class ConjuncaoDisjuncao {
    public static void main(String[] args) {
        String[][] verdadeiros = new String[3][2]; 
        String[][] falsos = new String[3][2]; 
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção que você deseja:\n" + "[1] Conjunção\n" + "[2] Disjunção\n" + "[3] Sair"));
        if(opcao <= 2){
            for (int i = 0; i < 3; i++) {
                verdadeiros[i][0] = JOptionPane.showInputDialog("Digite a "+ (i + 1) + "º frase VERDADEIRA :");
            }
            for (int i = 0; i < 3; i++) {
                falsos[i][0] = JOptionPane.showInputDialog("Digite a "+ (i + 1) + "º frase FALSA :");
            }
        }
        switch(opcao){
            case 1:
                StringBuilder tabela = new StringBuilder();
                tabela.append("TABELA VERDADE - CONJUNÇÃO (AND)\n\n");
                tabela.append(String.format("%-25s %-25s %-10s\n", "Frase A", "Frase B", "Resultado"));
                tabela.append(String.format("%-25s %-25s %-10s\n", "------------------------", "------------------------", "----------"));
                String[][] todasFrases = new String[6][2];
                for (int i = 0; i < 3; i++) {
                    todasFrases[i][0] = verdadeiros[i][0];
                    todasFrases[i][1] = "true";
                }
                for (int i = 0; i < 3; i++) {
                    todasFrases[i + 3][0] = falsos[i][0];
                    todasFrases[i + 3][1] = "false";
                }
                for (int i = 0; i < todasFrases.length; i++) {
                    for (int j = i; j < todasFrases.length; j++) {
                        String fraseA = todasFrases[i][0];
                        String fraseB = todasFrases[j][0];
                        boolean valorA = Boolean.parseBoolean(todasFrases[i][1]);
                        boolean valorB = Boolean.parseBoolean(todasFrases[j][1]);
                        boolean resultado = valorA && valorB;
                        String simbolo = resultado ? "V" : "F";
                        tabela.append(String.format("%-25s %-25s %-10s\n", fraseA, fraseB, simbolo));
                    }
                }
                javax.swing.JTextArea textArea = new javax.swing.JTextArea(tabela.toString());
                textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
                textArea.setEditable(false);
                javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane, "Tabela Verdade", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                StringBuilder tabelaDisjuncao = new StringBuilder();
                tabelaDisjuncao.append("TABELA VERDADE - DISJUNÇÃO (OR)\n\n");
                tabelaDisjuncao.append(String.format("%-25s %-25s %-10s\n", "Frase A", "Frase B", "Resultado"));
                tabelaDisjuncao.append(String.format("%-25s %-25s %-10s\n", "------------------------", "------------------------", "----------"));
                String[][] todasFrasesDisj = new String[6][2];
                for (int i = 0; i < 3; i++) {
                    todasFrasesDisj[i][0] = verdadeiros[i][0];
                    todasFrasesDisj[i][1] = "true";
                }
                for (int i = 0; i < 3; i++) {
                    todasFrasesDisj[i + 3][0] = falsos[i][0];
                    todasFrasesDisj[i + 3][1] = "false";
                }
                for (int i = 0; i < todasFrasesDisj.length; i++) {
                    for (int j = i; j < todasFrasesDisj.length; j++) {
                        String fraseA = todasFrasesDisj[i][0];
                        String fraseB = todasFrasesDisj[j][0];
                        boolean valorA = Boolean.parseBoolean(todasFrasesDisj[i][1]);
                        boolean valorB = Boolean.parseBoolean(todasFrasesDisj[j][1]);

                        boolean resultado = valorA || valorB;
                        String simbolo = resultado ? "V" : "F";

                        tabelaDisjuncao.append(String.format("%-25s %-25s %-10s\n", fraseA, fraseB, simbolo));
                    }
                }
                javax.swing.JTextArea textAreaDisj = new javax.swing.JTextArea(tabelaDisjuncao.toString());
                textAreaDisj.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
                textAreaDisj.setEditable(false);
                javax.swing.JScrollPane scrollPaneDisj = new javax.swing.JScrollPane(textAreaDisj);
                JOptionPane.showMessageDialog(null, scrollPaneDisj, "Tabela Verdade - Disjunção", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
                break;
        }
    }
    
}

