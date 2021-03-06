/*
 * Copyright (c) 2017-2018 JSR 371 expert group and contributors
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package jakarta.mvc.binding;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to enable Jakarta MVC-specific binding rules for a Jakarta RESTful Web Services parameter binding. It can
 * be placed on fields and method parameters together with Jakarta RESTful Web Services binding annotations such as
 * {@link jakarta.ws.rs.FormParam}, {@link jakarta.ws.rs.QueryParam}, etc.
 * <p>
 * MVC parameter binding differs from traditional Jakarta RESTful Web Services parameter binding in the following aspects:
 * <ul>
 * <li>In Jakarta RESTful Web Services binding and validation errors result in an exception being thrown which can
 * only be handled by a corresponding exception mapper. This usually doesn't make sense for web
 * applications, because errors must be processed by the controller, so they can be
 * displayed on the resulting HTML page. In case of Jakarta MVC bindings such errors don't prevent the controller
 * from being invoked and are instead made available via the injectable {@link BindingResult} class.</li>
 * <li>Jakarta RESTful Web Services parameter type conversion isn't locale-aware. The standard Jakarta RESTful Web Services converters
 * always use a fixed locale to parse numbers and dates. In MVC applications users typically
 * enter data into forms in their native locale. Therefore, Jakarta MVC bindings perform data type
 * conversion by respecting the request locale resolved via {@link jakarta.mvc.locale.LocaleResolver}.</li>
 * </ul>
 *
 * @author Christian Kaltepoth
 * @author Ivar Grimstad
 * @see BindingResult
 * @see jakarta.mvc.locale.LocaleResolver
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Documented
public @interface MvcBinding {}

