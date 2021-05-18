package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCShoppingListItemDao;
import model.ShoppingListItem;

@WebServlet("/shoppinglist")
public class ShoppingListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JDBCShoppingListItemDao dao = new JDBCShoppingListItemDao();
		System.out.println("Shopping list contents:");

		List<ShoppingListItem> items = dao.getAllItems();

		// lähetetään aika merkkijono JSP-sivulle attribuuttina
		req.setAttribute("shoppingitems", items);

		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");

		ShoppingListItem newItem = new ShoppingListItem();
		newItem.setOstos(title);
		JDBCShoppingListItemDao dao = new JDBCShoppingListItemDao();
		dao.addItem(newItem);

		req.setAttribute("shoppingitems", newItem);

		resp.sendRedirect("/shoppinglist");

	}
}
