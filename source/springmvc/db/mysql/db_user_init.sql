create user 'wxx_store' @ 'localhost' IDENTIFIED by 'wxx_store';

-- mysql中schema和database是一样的，所以下面两句话是相同的 
-- create schema wxx_store;
create database wxx_store;

grant privileges all on wxx_store.* to 'wxx_store' @'localhost';