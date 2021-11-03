package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaPripadaIntervalu;
    private boolean krajnjaPripadaIntervalu;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripadaIntervalu, boolean krajnjaPripadaIntervalu) throws IllegalArgumentException {
        if(pocetnaTacka > krajnjaTacka)
            throw new IllegalArgumentException("Unos nije validan!");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetnaPripadaIntervalu = pocetnaPripadaIntervalu;
        this.krajnjaPripadaIntervalu = krajnjaPripadaIntervalu;
    }

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        this.pocetnaPripadaIntervalu = false;
        this.krajnjaPripadaIntervalu = false;
    }

    public boolean isNull() {
        return this.equals(new Interval());
    }

    public boolean isIn(double tacka) {
        return ((tacka > pocetnaTacka && tacka < krajnjaTacka) ||
                (tacka == pocetnaTacka && pocetnaPripadaIntervalu) ||
                (tacka == krajnjaTacka && krajnjaPripadaIntervalu));
    }

    public Interval intersect(Interval i) {
        if(!i.isIn(this.pocetnaTacka) && !this.isIn(i.pocetnaTacka))
            return null;
        if(this.pocetnaTacka < i.pocetnaTacka) {
            this.pocetnaTacka = i.pocetnaTacka;
            this.pocetnaPripadaIntervalu = i.pocetnaPripadaIntervalu;
        }
        if(this.krajnjaTacka > i.krajnjaTacka) {
            this.krajnjaTacka = i.krajnjaTacka;
            this.krajnjaPripadaIntervalu = i.krajnjaPripadaIntervalu;
        }
        return this;
    }
    public static Interval intersect(Interval i1, Interval i2) {
        Interval i3 = new Interval();
        if(!i1.isIn(i2.pocetnaTacka) && !i2.isIn(i1.pocetnaTacka))
            return null;
        if(i1.pocetnaTacka < i2.pocetnaTacka) {
            i3.pocetnaTacka = i2.pocetnaTacka;
            i3.pocetnaPripadaIntervalu = i2.pocetnaPripadaIntervalu;
        }
        else {
            i3.pocetnaTacka = i1.pocetnaTacka;
            i3.pocetnaPripadaIntervalu = i1.pocetnaPripadaIntervalu;
        }
        if(i1.krajnjaTacka < i2.krajnjaTacka) {
            i3.krajnjaTacka = i1.krajnjaTacka;
            i3.krajnjaPripadaIntervalu = i1.krajnjaPripadaIntervalu;
        }
        else {
            i3.krajnjaTacka = i2.krajnjaTacka;
            i3.krajnjaPripadaIntervalu = i2.krajnjaPripadaIntervalu;
        }
        return i3;
    }

    @Override
    public String toString() {
        if(!this.isNull()) {
            if(pocetnaPripadaIntervalu){
                if(krajnjaPripadaIntervalu)
                    return "[" + pocetnaTacka + "," + krajnjaTacka + "]";
                else
                    return "[" + pocetnaTacka + "," + krajnjaTacka + ")";
            }
            else {
                if(krajnjaPripadaIntervalu)
                    return "(" + pocetnaTacka + "," + krajnjaTacka + "]";
                else
                    return "(" + pocetnaTacka + "," + krajnjaTacka + ")";
            }
        }
        return "()";
    }

    @Override
    public boolean equals(Object obj) {
        Interval that = (Interval) obj;
        return ((this.pocetnaTacka == that.pocetnaTacka) &&
                (this.krajnjaTacka == that.krajnjaTacka) &&
                (this.pocetnaPripadaIntervalu == that.pocetnaPripadaIntervalu) &&
                (this.krajnjaPripadaIntervalu == that.krajnjaPripadaIntervalu));
    }
}
