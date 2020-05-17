package utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import products.AddProduct;
import products.EditProduct;
import registration_login.HomePage;
import registration_login.LogIn;
import registration_login.SignUpPage;

public class ReadTextFile {

	//gets the hashmap from text file
	public static HashMap<String, String> getPathsMap() {
		HashMap<String, String> pathMap = new HashMap<String, String>();
	try{
	    InputStream fis=new FileInputStream("src/main/resources\\Locators.txt");
	    BufferedReader br=new BufferedReader(new InputStreamReader(fis));

	    for (String line = br.readLine(); line != null; line = br.readLine()) {
	       String [] pathArray= line.split(":");
	       pathMap.put(pathArray[0], pathArray[1]);
	    }
	    br.close();
	    return pathMap;
	}
	catch(Exception e){
		
	    System.err.println("Error: Target File Cannot Be Read");
	}
	return null;
	
}
	//loads paths into locator variables
	public static void readMap(HashMap<String, String> map) {
		SignUpPage.setUserName(map.get("username"));
		SignUpPage.setEmail(map.get("email"));
		SignUpPage.setPassword(map.get("password"));
		SignUpPage.setConfirmPassword(map.get("confirmpass"));
		SignUpPage.setSelectBox(map.get("selectbox"));
		SignUpPage.setSubmit(map.get("submit"));
		SignUpPage.setFormName(map.get("formname"));
		HomePage.setLogOut(map.get("logoutid"));
		HomePage.setLoggedUserName(map.get("loggedusername"));
		HomePage.setUserData(map.get("userdata"));
		LogIn.setLogIn(map.get("loginbtnxpath"));
		LogIn.setLogInError(map.get("loginerror"));
		LogIn.setUsernameLogin(map.get("usernamelogin"));
		LogIn.setPassLogin(map.get("password"));
		HomePage.setProducts(map.get("products_link_text"));
		AddProduct.setAddNew(map.get("add_new_link_text"));
		AddProduct.setProdName(map.get("prod_name_xpath"));
		AddProduct.setProdId(map.get("prod_id_xpath"));
		AddProduct.setProdDesc(map.get("prod_description_xpath"));
		AddProduct.setProdPrice(map.get("prod_price_xpath"));
		AddProduct.setSaveChanges(map.get("save_changes_xpath"));
		AddProduct.setUpdateSuccesful(map.get("update_successfull_xpath"));
		AddProduct.setViewButton(map.get("view_button_xpath"));
		EditProduct.setEditButton(map.get("edit_button_xpath"));
		EditProduct.setProductChangesEditForm(map.get("save_edited_prod_changes"));
		EditProduct.setSuccessfullyEdited(map.get("successfully_edited_product_message"));
	}
	
	public static void printMap(HashMap <String, String> mapa) {
		Iterator<Entry<String, String>> i = mapa.entrySet().iterator();
		while(i.hasNext()) {
			Map.Entry<String, String> entry = (Entry<String, String>)i.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}
}