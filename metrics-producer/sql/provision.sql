-- public.fpl_player_stats_current definition

-- Drop table

-- DROP TABLE public.fpl_player_stats_current;

CREATE TABLE public.fpl_player_stats_current (
	player_id int2 NOT NULL,
	average_minutes int2 NOT NULL,
	goals_scored int2 NOT NULL,
	assists int2 NOT NULL,
	clean_sheets int2 NOT NULL,
	goals_conceeded int2 NOT NULL,
	own_goals int2 NOT NULL,
	penalties_saved int2 NOT NULL,
	yellow_cards int2 NOT NULL,
	red_cards int2 NOT NULL,
	saves int2 NOT NULL,
	bonus int2 NOT NULL,
	bps int2 NOT NULL,
	influence numeric NOT NULL,
	creativity numeric NOT NULL,
	threat numeric NOT NULL,
	ict_index numeric NOT NULL,
	value int2 NOT NULL,
	transfers_balance int2 NOT NULL,
	selected int2 NOT NULL,
	transfers_in int2 NOT NULL,
	transfers_out int2 NOT NULL
);