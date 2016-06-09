import java.io.IOException;

public class Menu {
	// menu 1
	public void listCoffee() throws IOException {
		ShowCoffee cof = new ShowCoffee();
		System.out.println("-- รายชื่อกาแฟทั้งหมด --");
		cof.listCoffee();
	}

	// menu 2
	public void addCoffee() throws IOException {
		AddCoffee add = new AddCoffee();
		add.addCoffee();
	}

	// menu 3
	public void deleteCoffee() throws IOException {
		DeleteCoffee del = new DeleteCoffee();
		del.delCoffee();
	}
	
	// menu 4
	public void editCoffee() throws IOException {
		EditCoffee edit_coff = new EditCoffee();
		edit_coff.editCoffee();
	}

	// menu 5
	public void listRecipe() throws IOException {
		ShowRecipe rec = new ShowRecipe();
		rec.listRecipe();
	}
	
	// menu 6
		public void editRecipe() throws IOException {
			EditRecipe edit_recipe = new EditRecipe();
			edit_recipe.editRecipe();
		}

	// menu 7
	public void listAllCoffee_Recipe() throws IOException {
		ListCoffeeAndRecipe all = new ListCoffeeAndRecipe();
		all.listAll();
	}

}