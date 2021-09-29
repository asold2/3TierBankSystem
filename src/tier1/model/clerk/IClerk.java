package tier1.model.clerk;

public interface IClerk
{
  void withdraw(int id, double amount);
  void supply(int id, double amount);
}
