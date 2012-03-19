package trafficticket.taxoffice.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;


public class ViewTicketTableController extends MouseAdapter
{
	private JTable table;
	public ViewTicketTableController() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public ViewTicketTableController(JTable table) 
	{
		this.table = table;
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}
	@Override
	public void mousePressed(MouseEvent e)
	{
		System.out.println("row:" + this.table.rowAtPoint(e.getPoint()) + "  " + "col:" + this.table.columnAtPoint(e.getPoint()));
	}
}