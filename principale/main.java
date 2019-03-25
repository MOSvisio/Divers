package principale;
import dao.ProduitDAO;
import modele.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProduitDAO prod = ProduitDAO.getInstance();
		Produit test = new Produit("t", 20, 20, 1);
		Tva reduite = new Tva(0.5, "reduite");
		Achat listeCourse = new Achat();
		listeCourse.AjoutAchat(test, 20);
		listeCourse.Afficher();
		listeCourse.RetirerAchat(test);
		listeCourse.Afficher();
	}
}
