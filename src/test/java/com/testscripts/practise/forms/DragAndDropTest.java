package com.testscripts.practise.forms;

import org.testng.annotations.Test;

import com.practice.forms.pages.DragAndDropPage;
import com.practice.framework.utils.BaseTest;

public class DragAndDropTest extends BaseTest{

	@Test
	public void sampleDragAndDropTest() {
		DragAndDropPage dragPage = new DragAndDropPage();
		dragPage.loadPage();
		assertEquals(dragPage.getTextFromTarget(), "Drop here");
		dragPage.dragAndDrop();
		assertEquals(dragPage.getTextFromTarget(), "Dropped!");
	}
}
