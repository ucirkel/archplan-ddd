/*
 * Copyright 2023 Udo Cirkel (mail@udocirkel.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.archplan.ddd.lang.pattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//TODO klären: External Service / Infrastructure Service
/**
 * Indicates that an annotated class represents an "Infrastructure Service" as
 * defined by Domain-Driven Design (Eric Evans, 2003)
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@DddPattern(name = "Infrastructure Service")
@Documented
public @interface DddInfrastructureService {

    /**
     * Name of the Infrastructure Service as defined in the domain model and equally
     * in the ubiquitous language.
     * 
     * @return a name or an empty string
     */
    String name() default "";

}
