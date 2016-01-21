import java.util.ArrayList;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;


public class Primafinestra extends ApplicationWindow {
	private utils util;
	private DatabaseConfig connessione;
	private Personale p;
	/**
	 * Create the application window.
	 */
	public Primafinestra() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	 	util=new utils();
	 	//p=new personale();
		connessione = new DatabaseConfig();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		
		Label lblCamerieri = new Label(container, SWT.NONE);
		lblCamerieri.setBounds(10, 0, 55, 15);
		lblCamerieri.setText("Camerieri");
		{
			Button btnNewButton = new Button(container, SWT.NONE);
			btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			btnNewButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					MessageBox messageBox = new MessageBox(new Shell(), SWT.ICON_ERROR | SWT.OK);
					messageBox.setMessage("Ciaociao");
					messageBox.setText("NUOVA FINESTRA DI GESTIONE CAMERIERI");
					messageBox.open();
					
				}
			});
			btnNewButton.setBounds(10, 49, 106, 25);
			btnNewButton.setText("Gestisci Camerieri");
		}
		

		ArrayList<Personale> listaCamerieri = new ArrayList<Personale>();
		listaCamerieri=util.getListacam();
		System.out.println("");
  	  System.out.println("Adesso stampo arraylist da Primafinestra!!");
  	  
  	  ArrayList<Button> listaBottoni = new ArrayList<Button>();
  	  
  	  for (int i = 0; i < listaCamerieri.size(); i++) {
  		Personale cameriere = listaCamerieri.get(i);
			System.out.println(cameriere.getNome());
			
				Button btnNewButton_1 = new Button(container, SWT.NONE);
				btnNewButton_1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
					}
				});
				btnNewButton_1.setBounds(i*60+10, 20, 55, 25);
				btnNewButton_1.setText(cameriere.getId()+"-"+cameriere.getNome());
			
			listaBottoni.add(btnNewButton_1);
		}
		
		
		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Primafinestra window = new Primafinestra();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Gestione Ristorante");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(558, 300);
	}
}
