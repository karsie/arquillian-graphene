/**
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.arquillian.graphene.ftest.enricher;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;

import static org.junit.Assert.assertNotNull;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * @author Juraj Huska
 */
@RunWith(Arquillian.class)
@RunAsClient
public class TestInitializeNestedPageFragments {

    @FindBy(id = "foo")
    private InnerPageFragment innerPageFragment;

    @FindBy(id = "foo")
    private NestedStaticPageFragment nestedStaticPageFragment;

    @Drone
    private WebDriver browser;

    @Test
    public void testInnerPageFragmentInitialized() {
        assertNotNull("The inner page fragment should be already initialized!", innerPageFragment);
    }

    @Test
    public void testNestedStaticPageFragmentInitialized() {
        assertNotNull("The nested static page fragment should be already initialized!", nestedStaticPageFragment);
    }

    public class InnerPageFragment {

    }

    public static class NestedStaticPageFragment {

    }
}
