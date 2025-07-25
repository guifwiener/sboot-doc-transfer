CREATE SEQUENCE IF NOT EXISTS bank_order_seq;

CREATE TABLE IF NOT EXISTS public.bank_order (
    id BIGINT NOT NULL DEFAULT nextval('bank_order_seq'),
    order_value INTEGER,
    CONSTRAINT bank_order_pkey PRIMARY KEY (id)
);