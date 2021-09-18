package classes;

public class XAEDSMaps {
    public static final byte branco = 0;
    public static byte cinza = 1;
    public static byte preto = 2;
    private int d[], antecessor[], t[];
    int tAtual;
    private XGrafo grafo;

    public XAEDSMaps(XGrafo grafo) {
        this.grafo = grafo;
        int n = this.grafo.numVertices();
        this.d = new int[n];
        this.antecessor = new int[n];
        this.t = new int[n];
        tAtual = 1;
    }

    private void visitaBfs(int u, int cor[]) throws Exception {
        cor[u] = cinza;
        this.d[u] = 0;
        Fila fila = new Fila();
        fila.enfileira(u);
        while (!fila.vazia()) {
            Integer aux = (Integer) fila.desenfileira();
            u = aux.intValue();
            if (!this.grafo.listaAdjVazia(u)) {
                XGrafo.Aresta a = this.grafo.primeiroListaAdj(u);
                while (a != null) {
                    int v = a.v2();
                    if (cor[v] == branco) {
                        tAtual++;
                        t[v] = tAtual;
                        cor[v] = cinza;
                        this.d[v] = this.d[u] + 1;
                        this.antecessor[v] = u;
                        fila.enfileira(v);
                    }
                    a = this.grafo.proxAdj(u);
                }
            }
            cor[u] = preto;
        }
    }

    public void buscaEmLargura() throws Exception {
        int cor[] = new int[this.grafo.numVertices()];
        for (int u = 0; u < grafo.numVertices(); u++) {
            cor[u] = branco;
            this.d[u] = Integer.MAX_VALUE;
            this.antecessor[u] = -1;
            this.t[u] = -1;
        }
        t[0] = tAtual;
        for (int u = 0; u < grafo.numVertices(); u++)
            if (cor[u] == branco)
                this.visitaBfs(u, cor);
    }

    public void imprimeVetores() {
        System.out.println("\nANTECESSOR");
        for (int i = 0; i < this.grafo.numVertices(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < this.antecessor.length; i++) {
            System.out.print((antecessor[i] + 1) + " ");
        }
        System.out.println("\nNIVEIS ABAIXO DA RAIZ");
        for (int i = 0; i < this.grafo.numVertices(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < this.d.length; i++) {
            System.out.print((int) d[i] + " ");
        }
        System.out.println("\nTEMPO");
        for (int i = 0; i < this.grafo.numVertices(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < this.t.length; i++) {
            System.out.print((int) t[i] + " ");
        }
    }

    public void imprimeCaminho(int origem, int v) {
        if (origem == v) {
            System.out.print((origem + 1));
        } else if (this.antecessor[v] == -1) {
            System.out.println("Nao existe caminho de " + (origem + 1) + " ate " + (v + 1));
        } else {
            imprimeCaminho(origem, this.antecessor[v]);
            System.out.print(" -> " + (v + 1));
        }
    }

    public int d(int v) {
        return this.d[v];
    }

    public int antecessor(int v) {
        return this.antecessor[v];
    }

    public class Fila {
        private static class Celula {
            Object item;
            Celula prox;
        }

        private Celula frente;
        private Celula tras;

        // Operações
        public Fila() { // Cria uma Fila vazia
            this.frente = new Celula();
            this.tras = this.frente;
            this.frente.prox = null;
        }

        public void enfileira(Object x) {
            this.tras.prox = new Celula();
            this.tras = this.tras.prox;
            this.tras.item = x;
            this.tras.prox = null;
        }

        public Object desenfileira() throws Exception {
            Object item = null;
            if (this.vazia())
                throw new Exception("Erro : A fila esta vazia ");
            this.frente = this.frente.prox;
            item = this.frente.item;
            return item;
        }

        public boolean vazia() {
            return (this.frente == this.tras);
        }
    }
}