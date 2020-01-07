
package proyectoedd_vac;

/**
 *
 * @author IKAROS
 */
public class Split {
     Nodo mPuntero;
    Ordenable mLlave;
    Object mDato;

    public Split(Nodo pPuntero, Ordenable pLlave, Object pDato) {
        this.mPuntero = pPuntero;
        this.mLlave = pLlave;
        this.mDato = pDato;
    }

    public void setPuntero(Nodo mPuntero) {
        this.mPuntero = mPuntero;
    }

    public Nodo getPuntero() {
        return mPuntero;
    }

    public void setLlave(Ordenable mLlave) {
        this.mLlave = mLlave;
    }

    public Ordenable getLlave() {
        return mLlave;
    }

    public void setDato(Object mDato) {
        this.mDato = mDato;
    }

    public Object getDato() {
        return mDato;
    }
}
