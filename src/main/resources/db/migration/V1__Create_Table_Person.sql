-- Copiando estrutura para tabela rest_with_spring_boot.person
CREATE TABLE IF NOT EXISTS `person` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `firts_name` varchar(80) NOT NULL,
    `last_name` varchar(80) NOT NULL,
    `address` varchar(110) NOT NULL,
    `gender` varchar(6) NOT NULL,
    PRIMARY KEY (`id`)
    )