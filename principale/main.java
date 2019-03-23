package principale;
import dao.ProduitDAO;
import modele.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProduitDAO prod = ProduitDAO.getInstance();
		Tva reduite = new Tva(0.5, "reduite");
		Produit chips = new Produit("jean",1,1,5);
		System.out.println(chips.getId());
		reduite.getList();
	}
}
