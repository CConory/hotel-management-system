package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.BookDao;
import database.ClientDao;
import database.DescDao;
import database.LiveDao;
import database.RoomDao;
import type.Live;
import type.Room;

/**
 * Servlet implementation class CheckIn
 */
@WebServlet("/CheckIn")
public class CheckIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		ArrayList<Live> live = (ArrayList<Live>) session.getAttribute("live");
		ArrayList<Integer> roomnum = new ArrayList<Integer>();
		LiveDao liveDao = new LiveDao();
		BookDao bookDao = new BookDao();
		ClientDao clientDao=new ClientDao();
		DescDao descDao=new DescDao();
		RoomDao roomDao=new RoomDao();
				
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String birth=request.getParameter("birth");
		String tel=request.getParameter("tel");
		String sex=request.getParameter("sex");
		String remark=request.getParameter("remark");
		String indate=request.getParameter("indate");
		String outdate=request.getParameter("outdate");
		String sql;
	
		if(!clientDao.check(id)) {
			sql="insert into client values('"+id+"','"+name+"','"+sex+"','"+birth
					+"','"+id+"','"+tel+"','');";
			clientDao.Change(sql);
		}
		
		ArrayList<Integer> prices = descDao.GetPrice();
		
		int bookno = bookDao.GetCount() + 1;
		int price=0;
		
		for(int i=0;i<live.size();i+=2) {
			int roomno=-1;
			if(!(live.get(i).getName()=="")) {
				Live tmp=live.get(i);
				
				sql="Insert into live values "
						+ "("+tmp.getRoomNO()+",'"+tmp.getID()+"','"
						+indate+"','"+tmp.getName()+"');";
				System.out.println(sql);
				liveDao.Change(sql);
				roomno=tmp.getRoomNO();
			}
			if(!(live.get(i+1).getName()=="")) {
				Live tmp=live.get(i+1);
				
				sql="Insert into live values "
						+ "("+tmp.getRoomNO()+",'"+tmp.getID()+"','"
						+tmp.getDate()+"','"+tmp.getName()+"');";
				System.out.println(sql);
				liveDao.Change(sql);
				roomno=tmp.getRoomNO();
			}
			if(roomno!=-1) {
				roomnum.add(roomno);
				Room roomtmp = roomDao.SelectOne(""+roomno);
				price += prices.get(roomtmp.getTypeNo());
			}
		}
		
		sql="Insert into book values("+bookno+",'"+id+"','"+indate
			+"','"+outdate+"','no',"+price+",'"+remark+"');";
		bookDao.Change(sql);
		
		for(int i=0;i<roomnum.size();i++) {
			sql="insert into roombook values("+roomnum.get(i)+","+bookno+");";
			System.out.println(sql);
			bookDao.Change(sql);
			
			sql="insert into roomstatue values("+roomnum.get(i)+",'"+indate+"','"+outdate+"');";
			System.out.println(sql);
			bookDao.Change(sql);
		}
		
		PrintWriter out = response.getWriter();
		out.print("<head>\r\n" + "</head>\r\n" + "<body>");
		out.print("<h3 class=\"text-center\" align=\"center\">"
				+ "Successful</h3>");
		out.print("</body>");
		response.setHeader ("refresh", "1;URL=../nonpayment.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
