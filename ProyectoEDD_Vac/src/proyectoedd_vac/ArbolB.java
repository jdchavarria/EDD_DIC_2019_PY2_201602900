
package proyectoedd_vac;

/**
 *
 * @author IKAROS
 */
public class ArbolB {
     private Nodo mRaiz = null;
    private int mK = 2;
    private int mAltura = 0;

    public String toDot() {
        StringBuilder b = new StringBuilder();

        b.append("digraph g { \n node [shape=record];\n");

        b.append(mRaiz.toDot());

        b.append("}");

        return b.toString();
    }

    public ArbolB() {
    }

    public ArbolB(int k) {
        this.mK = k;
    }

    public ArbolB(Nodo pRaiz) {
        mK = pRaiz.getK();
        this.mRaiz = pRaiz;
        mAltura = 1;
    }

    public void insert(Ordenable key, Object obj) {
        if (this.mAltura == 0) {
            this.mRaiz = new Nodo(this.mK, key, obj);
            this.mAltura = 1;
            return;
        }

        Split splitted = insert(this.mRaiz, key, obj, 1);

        if (splitted == null) {
        } else {

            Nodo ptr = this.mRaiz;

            this.mRaiz =
                    new Nodo(this.mK, splitted.getLlave(), splitted.getDato());
            this.mRaiz.mPunteros[0] = ptr;
            this.mRaiz.mPunteros[1] = splitted.getPuntero();
            this.mAltura++;
        }
    }

    protected Split insert(Nodo node, Ordenable key, Object obj, int level) {

        Split splitted = null;
        Nodo ptr = null;

        int i = 0;
        while ((i < node.mB) && (key.mayorQue(node.mLlaves[i])))
            i++;

        if ((i < node.mB) && key.igualA(node.mLlaves[i])) {
            node.mDatos[i] = obj;
            return null;
        }

        if (level < this.mAltura) {

            splitted = insert(node.mPunteros[i], key, obj, level + 1);

            if (splitted == null)
                return null;
            else {
                key = splitted.mLlave;
                obj = splitted.mDato;
                ptr = splitted.mPuntero;
            }
        }

        i = node.mB - 1;
        while ((i >= 0) &&
               (node.mLlaves[i] == null || key.menorQue(node.mLlaves[i]))) {
            node.mLlaves[i + 1] = node.mLlaves[i];
            node.mDatos[i + 1] = node.mDatos[i];
            node.mPunteros[i + 2] = node.mPunteros[i + 1];
            i--;
        }

        node.mLlaves[i + 1] = key;
        node.mDatos[i + 1] = obj;
        if (splitted != null)
            node.mPunteros[i + 2] = splitted.mPuntero;
        node.mB++;

        if (node.mB > 2 * mK) {

            Nodo newnode = new Nodo(this.mK);
            newnode.mPunteros[this.mK] = node.mPunteros[node.mB];
            node.mPunteros[node.mB] = null;
            node.mB = this.mK + 1;
            for (i = 0; i < this.mK; i++) {
                newnode.mLlaves[i] = node.mLlaves[i + node.mB];
                node.mLlaves[i + node.mB] = null;
                newnode.mDatos[i] = node.mDatos[i + node.mB];
                node.mDatos[i + node.mB] = null;
                newnode.mPunteros[i] = node.mPunteros[i + node.mB];
                node.mPunteros[i + node.mB] = null;
            }
            node.mB--;

            splitted =
                    new Split(newnode, node.mLlaves[node.mB], node.mDatos[node.mB]);
            node.mLlaves[node.mB] = null;
            node.mDatos[node.mB] = null;
            newnode.mB = this.mK;
            node.mB = this.mK;

            return splitted;
        }

        return null;
    }

    public Object search(Ordenable key) {
        return search(key, mRaiz);
    }

    public Object search(Ordenable key, Nodo node) {

        if ((node == null) || (node.mB < 1)) {
            System.err.println("error");
            return null;
        }

        if (key.menorQue(node.mLlaves[0]))
            return search(key, node.mPunteros[0]);

        if (key.mayorQue(node.mLlaves[node.mB - 1]))
            return search(key, node.mPunteros[node.mB]);

        int i = 0;
        while ((i < node.mB - 1) && (key.mayorQue(node.mLlaves[i])))
            i++;

        if (key.igualA(node.mLlaves[i]))
            return node.mDatos[i];

        return search(key, node.mPunteros[i]);

    }


    public int getAltura() {
        return mAltura;
    }
}
