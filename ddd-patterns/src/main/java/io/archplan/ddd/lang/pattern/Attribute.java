/*
 * Copyright 2023 Udo Cirkel <mail@udocirkel.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.archplan.ddd.lang.pattern;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provides information in key-value form
 * <p>
 * Use this annotation as attribute of a Domain-Driven Design annotation to
 * provide additional information. The information should be related to the
 * represented domain object (problem space) or to the corresponding element of
 * your domain model (solution space). The information must be specified in
 * key-value form.
 *
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface Attribute {

    /**
     * A key that identifies the information.
     *
     * @return a non-empty key
     */
    String key();

    /**
     * A value that contains the information.
     *
     * @return a non-empty value
     */
    String val();

}
