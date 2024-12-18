package Scripts.LogManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogSystemService {

    public static void generateLog(String nomeArquivo, String conteudo) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatador);

        String logMessageWithTime = "Data de entrada: " + dataHoraFormatada + "\n" + conteudo + "\n";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            escritor.write("\n" + logMessageWithTime);
            System.out.println("Conteúdo adicionado ao arquivo " + nomeArquivo + " com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
}
