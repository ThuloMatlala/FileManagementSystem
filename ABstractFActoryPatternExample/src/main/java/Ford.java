public class Ford implements ICar {
    public IElectricCar GetElectrircCar() {
        return new FordEStacey();
    }

    public IFossilFuelCar GetFossilFuelCar() {
        return new FordFocus();
    }
}
