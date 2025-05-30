import java.text.SimpleDateFormat;
import java.util.Date;

public class Documento {
    private String nome;
    private String usuario;
    private long horaSolicitacao;
    private long horaImpressao;

    public Documento(String nome, String usuario) {
        this.nome = nome;
        this.usuario = usuario;
        this.horaSolicitacao = System.currentTimeMillis();
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public long getHoraSolicitacao() {
        return horaSolicitacao;
    }

    public void registrarImpressao() {
        this.horaImpressao = System.currentTimeMillis();
    }

    public long calcularTempoEspera() {
        return (horaImpressao - horaSolicitacao) / 1000;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = sdf.format(new Date(horaSolicitacao));
        return nome + " | Usuário: " + usuario + " | Solicitado em: " + dataFormatada;
    }
}