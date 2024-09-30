package laba4.servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import laba4.model.Repair;
import laba4.service.RepairService;

@WebServlet()
public class RepairServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RepairService repairService;

    public RepairServlet() {
        super();
        repairService = new RepairService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showCreateForm(request, response);
                break;
            case "/create":
                createRepair(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateRepair(request, response);
                break;
            case "/delete":
                deleteRepair(request, response);
                break;
            default:
                listRepairs(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listRepairs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Repair> repairs = repairService.getAllRepair();
        request.setAttribute("repairs", repairs);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Repair existingRepair = getRepairById(id);
        request.setAttribute("repair", existingRepair);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void createRepair(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String problemSubject = request.getParameter("problemSubject");
        String description = request.getParameter("description");

        long id = generateRepairId();
        Repair newRepair = new Repair(id, problemSubject, description);
        repairService.addRepair(newRepair);

        response.sendRedirect("index.jsp");
    }

    private void updateRepair(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String problemSubject = request.getParameter("problemSubject");
        String description = request.getParameter("description");

        Repair updatedRepair = new Repair(id, problemSubject, description);
        repairService.updateRepair(updatedRepair);

        response.sendRedirect("index.jsp");
    }

    private void deleteRepair(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        repairService.deleteRepair(id);

        response.sendRedirect("index.jsp");
    }

    private Repair getRepairById(long id) {
        List<Repair> repairs = repairService.getAllRepair();
        for (Repair repair : repairs) {
            if (repair.getId() == id) {
                return repair;
            }
        }
        return null;
    }

    private long generateRepairId() {
        List<Repair> repairs = repairService.getAllRepair();
        if (repairs.isEmpty()) {
            return 1;
        } else {
            long maxId = repairs.get(repairs.size() - 1).getId();
            return maxId + 1;
        }
    }
}