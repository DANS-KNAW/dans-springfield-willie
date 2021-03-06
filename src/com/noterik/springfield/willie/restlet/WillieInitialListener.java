/* 
* WillieInitialListener.java
* 
* Copyright (c) 2015 Noterik B.V.
* 
* This file is part of willie, related to the Noterik Springfield project.
*
* willie is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* willie is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with willie.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.noterik.springfield.willie.restlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.noterik.springfield.willie.homer.LazyHomer;

/**
 * WillieInitialListener.java
 *
 * @author Pieter van Leeuwen
 * @copyright Copyright: Noterik B.V. 2015
 * @package com.noterik.springfield.willie.restlet
 * 
 */
public class WillieInitialListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Willy: context created");
		
		ServletContext servletContext = event.getServletContext();
		
		//load LazyHomer		
		LazyHomer lh = new LazyHomer();
		lh.init(servletContext.getRealPath("/"));
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		//destroy LazyHomer
		LazyHomer.destroy();		
		
		System.out.println("Willy: context destroyed");
	}
}
